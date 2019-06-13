package net.tnemc.core.common.currency.formatter.impl;

import net.tnemc.core.common.currency.TNECurrency;
import net.tnemc.core.common.currency.formatter.FormatRule;
import org.bukkit.Location;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * The New Economy Minecraft Server Plugin
 * <p>
 * Created by creatorfromhell on 6/10/2019.
 * <p>
 * This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/ or send a letter to
 * Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 * Created by creatorfromhell on 06/30/2017.
 */
public class MinorRule implements FormatRule {
  @Override
  public String name() {
    return "minor";
  }

  @Override
  public String format(TNECurrency currency, BigDecimal amount, Location location, String player, String formatted) {
    String[] amountStr = (amount.toPlainString() + (amount.toPlainString().contains(".")? "" : ".00")).split("\\.");

    final BigInteger minor = new BigInteger(String.format("%-" + currency.getDecimalPlaces() + "s", amountStr[1]).replace(' ', '0'));
    return formatted.replace("<minor>", minor.toString() + " " + ((minor.compareTo(BigInteger.ONE) == 0)? currency.getSingleMinor() : currency.getPluralMinor()));
  }
}