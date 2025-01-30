package com.luismaia.helper

import com.cobblemon.mod.common.CobblemonItems
import com.cobblemon.mod.common.pokemon.Species
import eu.pb4.sgui.api.elements.GuiElement
import eu.pb4.sgui.api.elements.GuiElementBuilder
import eu.pb4.sgui.api.gui.SimpleGui
import net.minecraft.item.ItemStack
import net.minecraft.text.Text

object GuiHelper {
//    fun isClick(type: ButtonClick): Boolean {
//        if (type == ButtonClick.LEFT_CLICK) {
//            return true
//        }
//        return false
//    }
    enum class LineType {
        HORIZONTAL,
        VERTICAL
    }
    fun setLine(lineType: LineType, gui: SimpleGui, rowOrColumnPos: Int, startIndex: Int, endIndex: Int, guiElement: GuiElement) {
        val numCols = 9
        when (lineType) {
            LineType.HORIZONTAL -> {
                if (startIndex in 0 until numCols && endIndex in 0 until numCols && rowOrColumnPos in 0 until 6) {
                    for (col in startIndex..endIndex) {
                        val index = rowOrColumnPos * numCols + col
                        gui.setSlot(index,guiElement )
                    }
                } else {
                    println("Valores fora dos limites permitidos.")
                }
            }
            LineType.VERTICAL -> {
                if (startIndex in 0 until 6 && endIndex in 0 until 6 && rowOrColumnPos in 0 until numCols) {
                    for (row in startIndex..endIndex) {
                        val index = row * numCols + rowOrColumnPos
                        gui.setSlot(index,guiElement )
                    }
                } else {
                    println("Valores fora dos limites permitidos.")
                }
            }
        }
    }

    fun createEmptyButton(stack: ItemStack): GuiElementBuilder {

        return GuiElementBuilder(stack.item).setName(Text.empty())
    }

    fun createPokemonButton(species: Species): GuiElementBuilder {
        val itemStack = CobblemonItems.POKE_BALL.defaultStack

        val displayName = Text.literal("§b[§e#${species.nationalPokedexNumber}§b] §a${species.name}")
        return createEmptyButton(itemStack).setName(displayName)
    }

}
