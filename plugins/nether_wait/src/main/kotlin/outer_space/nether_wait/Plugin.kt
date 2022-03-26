package outer_space.nether_wait

import org.bukkit.plugin.java.JavaPlugin

class Plugin: JavaPlugin() {
    override fun onEnable() {
        this.logger.info("[outer_space::nether_wait] enabled")
    }

    override fun onDisable() {
        this.logger.info("[outer_space::nether_wait] disabled")
    }
}
