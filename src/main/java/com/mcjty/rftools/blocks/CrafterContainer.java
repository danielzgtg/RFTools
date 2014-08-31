package com.mcjty.rftools.blocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class CrafterContainer extends Container {
    private IInventory inventory;
    private EntityPlayer player;

    public CrafterContainer(EntityPlayer player, IInventory containerInventory, int xSize, int ySize) {
        inventory = containerInventory;
        this.player = player;
        layoutContainer(xSize, ySize);
    }

    private void layoutContainer(int xSize, int ySize) {
        addSlotToContainer(new Slot(inventory, 0, 12, 8));

        // Player inventory
        int leftCol = 85;
        int topRow = 100;
//        int leftCol = (xSize - 162) / 2 + 1;
        for (int py = 0 ; py < 3 ; py++) {
            for (int px = 0 ; px < 9 ; px++) {
                addSlotToContainer(new Slot(player.inventory, px + py * 9 + 9, leftCol + px * 18, topRow + py * 18));//ySize - (4-py) * 18 - 10));
            }
        }

        // Hotbar
        for (int hx = 0 ; hx < 9 ; hx++) {
            addSlotToContainer(new Slot(player.inventory, hx, leftCol + hx * 18, topRow + 3 * 18 + 5));//ySize - 24));
        }
    }

    public IInventory getContainerInventory() {
        return inventory;
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return inventory.isUseableByPlayer(entityPlayer);
    }

//    @Override
//    public ItemStack transferStackInSlot(EntityPlayer player, int i) {
//        ItemStack itemStack = null;
//        Slot slot = (Slot) inventorySlots.get(i);
//        if (slot != null && slot.getHasStack()) {
//            ItemStack itemStack1 = slot.getStack();
//            itemStack = itemStack1.copy();
//
//        }
//    }
}
