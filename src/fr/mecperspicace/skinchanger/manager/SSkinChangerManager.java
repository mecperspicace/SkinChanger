package fr.mecperspicace.skinchanger.manager;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import fr.mecperspicace.skinchanger.SMain;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.Random;

public class SSkinChangerManager {

    public static void SChangeSkin(Player player) {
        //  Init the player's connection
        GameProfile profile = ((CraftPlayer)player).getHandle().getProfile();
        PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;

        //  Send the packets
        connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, ((CraftPlayer)player).getHandle()));
        profile.getProperties().removeAll("textures");
        profile.getProperties().put("textures", getSkin(SMain.getInstance().getConfig().getString("mode")));
        connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, ((CraftPlayer)player).getHandle()));
    }

    private static Property getSkin(String mode) {
        //  Choose a random skin from the config
        Random r = new Random();
        int num = r.nextInt(4);
        switch (num) {
            //  Load the skin
            case 0: return new Property("textures", SMain.getInstance().getConfig().get("skin_textures." + mode + ".skin1.texture_value").toString(), SMain.getInstance().getConfig().get("skin_textures." + mode + ".skin1.texture_signature").toString());
            case 1: return new Property("textures", SMain.getInstance().getConfig().get("skin_textures." + mode + ".skin2.texture_value").toString(), SMain.getInstance().getConfig().get("skin_textures." + mode + ".skin2.texture_signature").toString());
            case 2: return new Property("textures", SMain.getInstance().getConfig().get("skin_textures." + mode + ".skin3.texture_value").toString(), SMain.getInstance().getConfig().get("skin_textures." + mode + ".skin3.texture_signature").toString());
            default: return new Property("textures", SMain.getInstance().getConfig().get("skin_textures." + mode + ".skin4.texture_value").toString(), SMain.getInstance().getConfig().get("skin_textures." + mode + ".skin4.texture_signature").toString());
        }
    }
}
