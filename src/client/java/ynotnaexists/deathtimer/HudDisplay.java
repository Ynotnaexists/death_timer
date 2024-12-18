package ynotnaexists.deathtimer;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import org.joml.Matrix4f;

import static net.fabricmc.loader.impl.util.StringUtil.wrapLines;

public class HudDisplay implements ClientModInitializer {
    private int timerTicks = 0; // Timer in ticks (20 ticks = 1 second)

    @Override
    public void onInitializeClient() {
        // Increment the timer every tick
        HudRenderCallback.EVENT.register((Matrix4f matrices, float tickDelta, VertexConsumerProvider vertexConsumers) -> {
            timerTicks++;

            // Convert ticks to seconds
            int seconds = timerTicks / 20;
            String timerText = "Timer: " + seconds + "s";

            OrderedText hiText = OrderedText.styledForwardsVisitedString("hi", Style.EMPTY);

            // Render the text
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.player != null) {
                client.textRenderer.drawWithOutline(
                        hiText,
                        10,
                        10,
                        70,
                        70,
                        matrices,
                        vertexConsumers,
                        100



                );
            }
        });
    }
}