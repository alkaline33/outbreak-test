package com.rs.game.npc.combat.impl.theatreofblood;

import java.util.ArrayList;
import java.util.List;

import com.rs.game.Animation;
import com.rs.game.Entity;
import com.rs.game.Hit;
import com.rs.game.Hit.HitLook;
import com.rs.game.World;
import com.rs.game.WorldTile;
import com.rs.game.npc.NPC;
import com.rs.game.npc.combat.CombatScript;
import com.rs.game.npc.combat.NPCCombatDefinitions;
import com.rs.game.npc.theatreofblood.TrollRanger;
import com.rs.game.tasks.WorldTask;
import com.rs.game.tasks.WorldTasksManager;
import com.rs.utils.Utils;

/**
 * 
 * @author Mr_Joopz @ Rune-server
 *
 */
public class TrollRangerCombat extends CombatScript {

	@Override
	public Object[] getKeys() {
		return new Object[] { 13711 };
	}

	/**
	 * Chuck pool
	 */

	private void poolAttack(NPC npc, Entity target) {

		final NPCCombatDefinitions defs = npc.getCombatDefinitions();
		int x = target.getX();
		int y = target.getY();
		List<String> tiles3 = new ArrayList<String>();
		ArrayList<Integer> distances = new ArrayList<Integer>();
		ArrayList<Entity> possibleTargets3 = npc.getPossibleTargets();
		for (Entity t : possibleTargets3) {
			if (tiles3.contains(t.getX() + " " + t.getY() + " " + t.getPlane())) {
				continue;
			}
			//// ((Player) t).getPackets().sendProjectile(null, new WorldTile(npc), new
			//// WorldTile(t), 570, 30, 30, 1, 0, 0, 0, 0);
			// ((Player) t).getPackets().sendProjectile(null, new WorldTile(npc), new
			//// WorldTile(t.getX() + 1, t.getY(), 0), 570, 30, 30, 1, 0, 0, 0, 0);
			// ((Player) t).getPackets().sendProjectile(null, new WorldTile(npc), new
			//// WorldTile(t.getX() - 1, t.getY(), 0), 570, 30, 30, 1, 0, 0, 0, 0);
			World.sendProjectile(npc, t, 570, 80, 30, 40, 20, 5, 0);
			World.sendProjectile(npc, new WorldTile(t.getX() + 1, t.getY(), 0), 570, 80, 30, 40, 20, 5, 0);
			World.sendProjectile(npc, new WorldTile(t.getX() - 1, t.getY(), 0), 570, 80, 30, 40, 20, 5, 0);

			World.sendProjectile(npc, new WorldTile(t.getX(), t.getY() - 1, 0), 570, 80, 30, 40, 20, 5, 0);
			World.sendProjectile(npc, new WorldTile(t.getX() + 1, t.getY() - 1, 0), 570, 80, 30, 40, 20, 5, 0);
			World.sendProjectile(npc, new WorldTile(t.getX() - 1, t.getY() - 1, 0), 570, 80, 30, 40, 20, 5, 0);

			World.sendProjectile(npc, new WorldTile(t.getX() + 1, t.getY() + 1, 0), 570, 80, 30, 40, 20, 5, 0);
			World.sendProjectile(npc, new WorldTile(t.getX(), t.getY() + 1, 0), 570, 80, 30, 40, 20, 5, 0);
			World.sendProjectile(npc, new WorldTile(t.getX() - 1, t.getY() + 1, 0), 570, 80, 30, 40, 20, 5, 0);
			tiles3.add(t.getX() + " " + t.getY() + " " + t.getPlane());
			distances.add(Utils.getDistance(t, npc));
		}

		for (int i = 0; i < tiles3.size(); i++) {

			String s = tiles3.get(i);
			WorldTile tile = new WorldTile(Integer.valueOf(s.split("\\s")[0]), Integer.valueOf(s.split("\\s")[1]), Integer.valueOf(s.split("\\s")[2]));
			WorldTasksManager.schedule(new WorldTask() {
				@Override
				public void run() {
					WorldTasksManager.schedule(new WorldTask() {
						int loop;

						@Override
						public void run() {
							for (Entity t : possibleTargets3) {
								if (t.getX() != tile.getX() || t.getY() != tile.getY()) {
									stop();
								}
								// if (loop == 1) {
								// World.spawnTemporaryObject(new WorldObject(5986, 10, 0, tile.getX(),
								// tile.getY(), 0), 60000);
								if (t.getX() == tile.getX() && t.getY() == tile.getY()) {
									t.applyHit(new Hit(npc, 400, HitLook.REGULAR_DAMAGE));
								}
								else if (t.getX() == tile.getX() + 1 && t.getY() == tile.getY()) {
									t.applyHit(new Hit(npc, 400, HitLook.REGULAR_DAMAGE));
								}
								else if (t.getX() == tile.getX() - 1 && t.getY() == tile.getY()) {
									t.applyHit(new Hit(npc, 400, HitLook.REGULAR_DAMAGE));
								}
								else if (t.getX() == tile.getX() && t.getY() - 1 == tile.getY()) {
									t.applyHit(new Hit(npc, 400, HitLook.REGULAR_DAMAGE));
								}
								else if (t.getX() == tile.getX() + 1 && t.getY() - 1 == tile.getY()) {
									t.applyHit(new Hit(npc, 400, HitLook.REGULAR_DAMAGE));
								}
								else if (t.getX() == tile.getX() - 1 && t.getY() - 1 == tile.getY()) {
									t.applyHit(new Hit(npc, 400, HitLook.REGULAR_DAMAGE));
								}
								else if (t.getX() == tile.getX() && t.getY() + 1 == tile.getY()) {
									t.applyHit(new Hit(npc, 400, HitLook.REGULAR_DAMAGE));
								}
								else if (t.getX() == tile.getX() + 1 && t.getY() + 1 == tile.getY()) {
									t.applyHit(new Hit(npc, 400, HitLook.REGULAR_DAMAGE));
								}
								else if (t.getX() == tile.getX() - 1 && t.getY() + 1 == tile.getY()) {
									t.applyHit(new Hit(npc, 400, HitLook.REGULAR_DAMAGE));
								} else {
									t.applyHit(new Hit(npc, 40, HitLook.DESEASE_DAMAGE));
								}
							}
							loop++;
						}
					}, 0, 1);

				}

			}, distances.get(i) - 1);
		}
		return;
	}

	@Override
	public int attack(final NPC npc, final Entity target) {
		TrollRanger pitrock = (TrollRanger) npc;
		final NPCCombatDefinitions defs = npc.getCombatDefinitions();
		npc.setForceMultiArea(true);
		npc.setForceMultiAttacked(true);
		npc.setCapDamage(1000);
		npc.setForceTargetDistance(64);
		int count = pitrock.getCount();
		switch (count) {
		default:
			npc.setNextAnimation(new Animation(defs.getAttackEmote()));
			poolAttack(npc, target);
			break;
		}
		return defs.getAttackDelay();
	}
}
