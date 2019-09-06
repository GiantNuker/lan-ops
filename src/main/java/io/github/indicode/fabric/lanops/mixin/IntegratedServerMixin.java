package io.github.indicode.fabric.lanops.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.MinecraftClient;
import net.minecraft.server.OperatorEntry;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.integrated.IntegratedServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * @author Indigo Amann
 */
@Mixin(IntegratedServer.class)
public class IntegratedServerMixin {
    @Redirect(method = "openToLan", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/PlayerManager;setCheatsAllowed(Z)V"))
    public void getPermissionLevel(PlayerManager manager, boolean cheetz) {
        if (cheetz) {
            manager.getOpList().add(new OperatorEntry(MinecraftClient.getInstance().player.getGameProfile(), 4, manager.getOpList().isOp(MinecraftClient.getInstance().player.getGameProfile())));
        }
    }
}
