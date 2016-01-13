package main.ironbackpacks.proxies;

import main.ironbackpacks.ModInformation;
import main.ironbackpacks.client.KeyHandler;
import main.ironbackpacks.client.renderer.RenderBackpack;
import main.ironbackpacks.entity.EntityBackpack;
import main.ironbackpacks.events.ClientEventHandler;
import main.ironbackpacks.config.ConfigAdaptor;
import main.ironbackpacks.items.ItemRegistry;
import main.ironbackpacks.network.ClientPackMessage;
import main.ironbackpacks.util.IronBackpacksConstants;
import main.ironbackpacks.util.PlayerBackpackProperties;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;

/**
 * The client proxy
 */
public class ClientProxy extends CommonProxy {

    public EntityPlayer getClientPlayer(){
        return Minecraft.getMinecraft().thePlayer;
    }

    public void preInit(){
        initKeybindings();
        initItemRenderers();
        initEntityRenderers(); //for 1.9
        initClientEventHandler();
    }

    private void initEntityRenderers(){
//        RenderingRegistry.registerEntityRenderingHandler(EntityBackpack.class, //some IRenderFactory) //code for 1.9+
    }

    public void init(){
        RenderingRegistry.registerEntityRenderingHandler(EntityBackpack.class, new RenderBackpack(Minecraft.getMinecraft().getRenderManager())); //deprecated past 1.8
    }

    public String getModVersion(){
        return ModInformation.VERSION;
    }

    public String getRemoteUpdatedVersion(){
        return ConfigAdaptor.getLatestFilenameFromCurse(IronBackpacksConstants.Miscellaneous.URL_UPDATED_VERSION);
    }

    private void initKeybindings() {
        KeyHandler.init();
    }

    private void initClientEventHandler(){
        FMLCommonHandler.instance().bus().register(new ClientEventHandler());
    }

    private void initItemRenderers(){
        ItemRegistry.registerItemRenders();
    }

    public void updatePackOnClient(ClientPackMessage message) {
//        World world = Minecraft.getMinecraft().theWorld;
//        EntityPlayer player = (EntityPlayer) world.getEntityByID(Minecraft.getMinecraft().thePlayer.getEntityId());
//
//        if (data != null)
//            data.sync(message.changeMode, message.spellcast);
    }

}
