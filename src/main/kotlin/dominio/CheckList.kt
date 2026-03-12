package dominio

class CheckList {
    val items = mutableListOf<Item>()

    fun agregar(item: Item) {
        items.add(item)
    }

    fun eliminar(item: Item) {
        items.remove(item)
    }

    fun estaCumplida() = items.isNotEmpty() && items.all { it.cumplido }

    fun estaEnProgreso() = items.any { it.cumplido } && items.any { !it.cumplido }

    fun estaPendiente() = !estaCumplida() && !estaEnProgreso()

    fun porcentajeCumplimiento() = if (items.isEmpty()) 0.0 else items.count { it.cumplido } * 100.0 / items.size

}