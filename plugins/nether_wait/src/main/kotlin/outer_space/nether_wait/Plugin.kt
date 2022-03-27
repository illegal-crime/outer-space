package outer_space.nether_wait

import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftPlayer
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener as EventListener
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitRunnable

class Plugin: JavaPlugin() {
    override fun onEnable() {
        this.server.pluginManager.registerEvents(PlayerMoveListenerImpl(this), this)
    }
}

class PlayerMoveListenerImpl(
    private val plugin: Plugin,
): EventListener {
    @EventHandler
    fun onPlayerMove(event: PlayerMoveEvent) {
        val player = event.player as CraftPlayer
        val playerHandle = player.handle

        if (player.gameMode == GameMode.CREATIVE) return
        if (player.location.block.type != Material.NETHER_PORTAL) return
        if (playerHandle.isCrouching) return

        playerHandle.abilities.invulnerable = true
        playerHandle.onUpdateAbilities()

        object: BukkitRunnable() {
            override fun run() {
                playerHandle.abilities.invulnerable = false
                playerHandle.onUpdateAbilities()
            }
        }.runTaskLater(this.plugin, 3)
    }
}
