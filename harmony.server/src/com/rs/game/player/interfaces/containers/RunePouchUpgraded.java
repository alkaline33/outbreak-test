package com.rs.game.player.interfaces.containers;

import java.io.Serializable;

import com.rs.cache.loaders.ItemDefinitions;
import com.rs.game.item.Item;
import com.rs.game.item.ItemsContainer;
import com.rs.game.player.Player;
import com.rs.utils.Colors;

public class RunePouchUpgraded implements Serializable {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -8752068490060348315L;

	/**
	 * Items in the chest currently.
	 */
	private ItemsContainer<Item> container;

	/**
	 * The player
	 */
	private Player player;

	/**
	 * Constructor
	 */
	public RunePouchUpgraded() {
		container = new ItemsContainer<Item>(10, true);
	}

	/**
	 * Sets the player.
	 * 
	 * @param player
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * Get the chest container.
	 * 
	 * @return
	 */
	public ItemsContainer<Item> getContainer() {
		return container;
	}

	/**
	 * Adds loot to the chest container.
	 * 
	 * @param items
	 *            {@link Item} the loot.
	 * @return {@value true} if loot was added to chest container.
	 */
	public boolean add(Item... items) {
		for (Item item : items) {
			if (item.getId() < 554 || item.getId() > 566 && item.getId() != 9075 && item.getId() != 21773)
				return false;

		}
		for (Item item : items) {
			if (!container.contains(item)) {
				if (!(container.freeSlots() >= items.length)) {
					player.sendMessage("<col=ff0000>Your Rune pouch is currently full. Please empty it to add additional runes.</col>");
					return false;
				}
			}
		}
		for (Item item : items) {
			container.add(item);
			player.getInventory().deleteItem(item);
			player.sendMessage(Colors.red + "Item added to rune pouch: " + item.getAmount() + " x " + item.getName() + "");
		}

		return true;
	}

	/**
	 * Deposits all the chest contents to their bank.
	 * 
	 * @return {@value true} if the items were deposited.
	 */
	public boolean depositChestToBank() {
		for (Item item : getContainer().getItems()) {

			if (item == null)
				continue;

			ItemDefinitions def = item.getDefinitions();

			if (def.isNoted() && def.getCertId() != -1)
				item.setId(def.getCertId());

			player.getBank().addItem(item, true);
		}
		container.clear();
		return true;
	}

}
