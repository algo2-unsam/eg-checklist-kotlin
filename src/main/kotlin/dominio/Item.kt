package dominio

class Item(val descripcion: String = "", var cumplido: Boolean = false) {

    fun cambiarEstado() {
        cumplido = !cumplido
    }
}