package net.tnemc.signs.signs;

import net.tnemc.core.menu.Menu;
import org.bukkit.block.Sign;

import java.util.UUID;

/**
 * The New Economy Minecraft Server Plugin
 * <p>
 * Created by Daniel on 11/27/2018.
 * <p>
 * This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/ or send a letter to
 * Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 * Created by creatorfromhell on 06/30/2017.
 */
public interface SignStep {

  int step();

  boolean onSignInteract(final Sign sign, final UUID player, final boolean rightClick, final boolean shifting);

  default Menu getMenu(final UUID player) {
    return null;
  }

  default boolean onMenuOpen(final Sign sign, final UUID player) {
    return true;
  }

  default boolean onMenuClose(final Sign sign, final UUID player) {
    return true;
  }
}