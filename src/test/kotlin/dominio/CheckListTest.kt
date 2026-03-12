package dominio

import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CheckListTest : DescribeSpec({
    isolationMode = IsolationMode.InstancePerTest

    describe("Tests CheckList") {

        describe("Dada una checklist vacía") {
            val checkListVacia = CheckList()

            it("está pendiente y no cumplida ni en progreso") {
                checkListVacia.estaCumplida() shouldBe false
                checkListVacia.estaEnProgreso() shouldBe false
                checkListVacia.estaPendiente() shouldBe true
            }
            it("tiene porcentaje de cumplimiento nulo") {
                checkListVacia.porcentajeCumplimiento() shouldBe 0.0
            }
        }

        describe("Dada una checklist con todos los ítems pendientes") {
            val checkListTodosPendientes = CheckList()
            checkListTodosPendientes.agregar(Item("item 1"))
            checkListTodosPendientes.agregar(Item("item 2"))

            it("está pendiente y no cumplida ni en progreso") {
                checkListTodosPendientes.estaCumplida() shouldBe false
                checkListTodosPendientes.estaEnProgreso() shouldBe false
                checkListTodosPendientes.estaPendiente() shouldBe true
            }
            it("tiene porcentaje de cumplimiento nulo") {
                checkListTodosPendientes.porcentajeCumplimiento() shouldBe 0.0
            }
        }

        describe("Dada una checklist con algunos ítems cumplidos") {
            val checkListEnProgreso = CheckList()
            checkListEnProgreso.agregar(Item("item cumplido", cumplido = true))
            checkListEnProgreso.agregar(Item("item pendiente"))

            it("está en progreso y no cumplida ni pendiente") {
                checkListEnProgreso.estaCumplida() shouldBe false
                checkListEnProgreso.estaEnProgreso() shouldBe true
                checkListEnProgreso.estaPendiente() shouldBe false
            }
            it("tiene porcentaje de cumplimiento parcial") {
                checkListEnProgreso.porcentajeCumplimiento() shouldBe 50.0
            }
        }

        describe("Dada una checklist con todos los ítems cumplidos") {
            val checkListCumplida = CheckList()
            checkListCumplida.agregar(Item("item 1", cumplido = true))
            checkListCumplida.agregar(Item("item 2", cumplido = true))

            it("está cumplida y no en progreso ni pendiente") {
                checkListCumplida.estaCumplida() shouldBe true
                checkListCumplida.estaEnProgreso() shouldBe false
                checkListCumplida.estaPendiente() shouldBe false
            }
            it("tiene porcentaje de cumplimiento total") {
                checkListCumplida.porcentajeCumplimiento() shouldBe 100.0
            }
        }
    }
})