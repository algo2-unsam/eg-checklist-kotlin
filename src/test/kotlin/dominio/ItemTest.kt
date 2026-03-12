package dominio

import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ItemTest : DescribeSpec({
    isolationMode = IsolationMode.InstancePerTest

    describe("Tests Item") {

        describe("Dado un ítem pendiente") {
            val itemPendiente = Item("item")

            it("al cambiar estado pasa a cumplido") {
                itemPendiente.cambiarEstado()
                itemPendiente.cumplido shouldBe true
            }
            it("al cambiar estado dos veces vuelve a pendiente") {
                itemPendiente.cambiarEstado()
                itemPendiente.cambiarEstado()
                itemPendiente.cumplido shouldBe false
            }
        }
    }
})