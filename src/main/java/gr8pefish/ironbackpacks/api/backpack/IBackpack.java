package gr8pefish.ironbackpacks.api.backpack;

import com.google.common.base.Preconditions;
import gr8pefish.ironbackpacks.api.IronBackpacksAPI;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

/**
 * Used to mark an item as a backpack so it can be picked up by internal handling.
 */
public interface IBackpack {

    /**
     * Gets the container object for all backpack data from the stack.
     *
     * @param stack - The stack to get the backpack information from
     * @return - The container object for all backpack data
     */
    @Nonnull
    default BackpackInfo getBackpackInfo(@Nonnull ItemStack stack) {
        Preconditions.checkNotNull(stack, "ItemStack cannot be null");

        return BackpackInfo.fromStack(stack);
    }

    /**
     * Gets the color backpack data from the stack.
     *
     * @param stack - The stack to get the backpack information from
     * @return - The RGB color; -1 if none
     */
    default int getBackpackColor(@Nonnull ItemStack stack) {
        Preconditions.checkNotNull(stack, "ItemStack cannot be null");

        return BackpackInfo.getColor(stack);
    }

    /**
     * Writes the modified backpack data back to the stack. Must be called after any changes are made to the BackpackInfo
     *
     * @param stack        - Stack to write backpack data to
     * @param backpackInfo - Modified data to write to stack
     */
    default void updateBackpack(@Nonnull ItemStack stack, @Nonnull BackpackInfo backpackInfo) {
        Preconditions.checkNotNull(stack, "ItemStack cannot be null");
        Preconditions.checkNotNull(backpackInfo, "BackpackInfo cannot be null");

        IronBackpacksAPI.applyPackInfo(stack, backpackInfo);
    }
}
