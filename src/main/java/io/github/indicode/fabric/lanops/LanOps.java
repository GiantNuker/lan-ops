package io.github.indicode.fabric.lanops;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.CommandRegistry;
import net.minecraft.server.dedicated.command.DeOpCommand;
import net.minecraft.server.dedicated.command.OpCommand;

/**
 * @author Indigo Amann
 */
public class LanOps implements ModInitializer {
    @Override
    public void onInitialize() {
        CommandRegistry.INSTANCE.register(false, OpCommand::register);
        CommandRegistry.INSTANCE.register(false, DeOpCommand::register);
    }
}
