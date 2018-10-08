data class Node(val idNode: Int) {
    val listValue = arrayListOf<Pair<Int, String>>()
    var nextNode: Node = this
    var prevNode: Node = this
}