package com.rs.game.player.content;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import com.rs.cores.CoresManager;
import com.rs.game.player.Player;

/**
 * Handles highscores.
 * @author Matrix
 * @edited by ARMAR X K1NG
 */
public class Highscores {

	/**
	 * The lock object variable.
	 */
	private static Object lock = new Object();

	/**
	 * Update a player to the highscores.
	 * @param player The player reference.
	 * @param displayname The player's display name.
	 */
	public static void highscores(final Player player, final String displayname) {
		if(player == null) {
			return;
		}
		if(player.getRights() == 2 || player.isPvpMode()) {
			return;
		}
		if(!requirements(player)) {
			return;
		}
		final short[] levels = getLevels(player);
		final double[] xp = getXp(player);
		final int total = getTotalLevel(player);
		final String totalxp = getTotalXp(player);
		final String hsWebsite = "http://drygonscape.co.uk/highscores/";
		final String PASS = "nike2323";
		final int bosskills = player.BossKills();
		final int gameMode = player.isIronman() ? 2 : 1;
		final int expType = player.isHeroic() ? 4 : player.isHard() ? 3 : player.isAverage() ? 2 : player.isEasy() ? 1 : 0;
		final long myclanxp = player.MyClanXp();
		final int combatlvl = player.getSkills().getCombatLevelWithSummoning();
		final int titleid = 1;
		if (levels == null || xp == null || totalxp == null) {
			return;
		}
		CoresManager.slowExecutor.execute(new Runnable() {
			@Override
			public void run() {
				try {
					synchronized(lock) {
						int rights = player.getRights() == 1 ? 1 : player.isIronman() ? 7 : player.isEasy() ? 3 : player.isAverage() ? 4 : player.isHard() ? 5 :  player.isHeroic() ? 6 : player.getRights();
						URL url = new URL(""+hsWebsite+"updatehighscores.php?pass="+PASS+"&username="+
								player.getDisplayName().replaceAll(" ", "_")+"&rights="+rights+"&total="+total+"&totalkills="+bosskills+"&attack="+levels[0]+"&defence="+levels[1]+"&strength="+levels[2]+"" +
								"&constitution="+levels[3]+"&ranged="+levels[4]+"&prayer="+levels[5]+"&magic="+levels[6]+"&cooking="+levels[7]+"&woodcutting="+levels[8]+"" +
								"&fletching="+levels[9]+"&fishing="+levels[10]+"&firemaking="+levels[11]+"&crafting="+levels[12]+"&smithing="+levels[13]+"&mining="+levels[14]+"" +
								"&herblore="+levels[15]+"&agility="+levels[16]+"&thieving="+levels[17]+"&slayer="+levels[18]+"&farming="+levels[19]+"&runecrafting="+levels[20]+"" +
								"&construction="+levels[21]+"&hunter="+levels[22]+"&summoning="+levels[23]+"&titleid="+titleid+"" +"&combatlvl="+ combatlvl +
								"&totalxp="+totalxp+"&attackxp="+xp[0]+"&defencexp="+xp[1]+"&strengthxp="+xp[2]+"" +"&dungeoneering="+levels[24]+ "&dungeoneeringxp="+xp[24]+
								"&constitutionxp="+xp[3]+"&rangedxp="+xp[4]+"&prayerxp="+xp[5]+"&magicxp="+xp[6]+"&cookingxp="+xp[7]+"&woodcuttingxp="+xp[8]+"" +
								"&fletchingxp="+xp[9]+"&fishingxp="+xp[10]+"&firemakingxp="+xp[11]+"&craftingxp="+xp[12]+"&smithingxp="+xp[13]+"&miningxp="+xp[14]+"" +
								"&herblorexp="+xp[15]+"&agilityxp="+xp[16]+"&thievingxp="+xp[17]+"&slayerxp="+xp[18]+"&farmingxp="+xp[19]+"&runecraftingxp="+xp[20]+"" +
								"&exptype="+expType+"" +"&gamemode="+gameMode+"" +
								"&constructionxp="+xp[22]+"&hunterxp="+xp[21]+"&summoningxp="+xp[23]+(displayname != null ? "&oldname="+displayname.replaceAll(" ", "_")+"" : "")+"");
						//System.out.println(url);
						url.openStream().close();
					}
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Check if the player has the requirements to be on the highscores.
	 * @param player The player reference.
	 * @return If the player has the requirements {@code true}.
	 */
	private static boolean requirements(Player player) {
		//if(player.isEasy())
		//	return false;
		return true;
	}

	/**
	 * Get all the player's levels.
	 * @param player The player refrence.
	 * @return A short array containing all the player's levels.
	 */
	private static short[] getLevels(Player player) {
		return player.getSkills().getLevels();
	}

	/**
	 * Get the player's total level.
	 * @param player The player reference.
	 * @return The player's total level.
	 */
	private static int getTotalLevel(Player player) {
		int totallevel = 0;
		for(int i = 0; i <= 24; i++) {
			totallevel += player.getSkills().getLevelForXp(i);
		}
		return totallevel;
	}

	/**
	 * Get all the player's experience in a double array.
	 * @param player The player reference.
	 * @return All the player's experience in a double array.
	 */
	private static double[] getXp(Player player) {
		return player.getSkills().getXp();
	}

	/**
	 * Get the player's total experience.
	 * @param player The player reference.
	 * @return The player's total experience.
	 */
	private static String getTotalXp(Player player) {
		double totalxp = 0;
		for(double xp : player.getSkills().getXp()) {
			totalxp += xp;
		}
		NumberFormat formatter = new DecimalFormat("#######");
		return formatter.format(totalxp);
	}
}