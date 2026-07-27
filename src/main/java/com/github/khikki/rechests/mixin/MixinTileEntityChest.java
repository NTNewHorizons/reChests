package com.github.khikki.rechests.mixin;

import com.github.khikki.rechests.block.VariantChestBlock;
import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TileEntityChest.class)
public abstract class MixinTileEntityChest extends TileEntity implements IInventory {

    @Inject(method = "func_145977_a", at = @At("HEAD"), cancellable = true)
    private void isSameChest(int p_145977_1_, int p_145977_2_, int p_145977_3_, CallbackInfoReturnable<Boolean> cir){
        if (this.worldObj == null)
        {
            cir.setReturnValue(false);
        }
        else
        {
            Block block = this.worldObj.getBlock(p_145977_1_, p_145977_2_, p_145977_3_);
            if (block instanceof VariantChestBlock){
                cir.setReturnValue(false);
            }
        }
    }
}
