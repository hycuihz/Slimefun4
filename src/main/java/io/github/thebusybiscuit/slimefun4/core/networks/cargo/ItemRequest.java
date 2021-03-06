package io.github.thebusybiscuit.slimefun4.core.networks.cargo;

import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

class ItemRequest {

	private final ItemStack item;
	private final ItemTransportFlow flow;
	private final Location terminal;
	private final int slot;

	public ItemRequest(Location terminal, int slot, ItemStack item, ItemTransportFlow flow) {
		this.terminal = terminal;
        this.item = item;
        this.slot = slot;
		this.flow = flow;
	}
	
	public Location getTerminal() {
		return this.terminal;
	}
	
	public ItemStack getItem() {
		return this.item;
	}

	public ItemTransportFlow getDirection() {
		return this.flow;
	}

	public int getSlot() {
		return this.slot;
	}

	@Override
	public int hashCode() {
		return Objects.hash(item, slot, flow, terminal);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ItemRequest) {
			ItemRequest request = (ItemRequest) obj;
			return Objects.equals(item, request.item) && Objects.equals(terminal, request.terminal) && slot == request.slot && flow == request.flow;
		} else {
			return false;
		}
	}
}
