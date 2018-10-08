class ChordNode {
    val nodes = arrayListOf<Node>()
    fun firstNode() = if (nodes.size > 0 ) nodes.sortedBy { it.idNode }[0] else null
    fun lastNode() = if (nodes.size > 0) nodes.sortedBy { it.idNode }[nodes.size - 1] else null
    fun addNode(node: Node) {
        if (nodes.size == 1) {
            nodes[0].nextNode = node
            nodes[0].prevNode = node
            node.nextNode = nodes[0]
            node.prevNode = nodes[0]
        } else {
            var next = nodes.find { it.idNode > node.idNode }
            if (next == null) next = firstNode()
            next?.let {
                node.nextNode = it
                it.prevNode = node
            }
            var prev = nodes.find { it.idNode < node.idNode }
            if (prev == null) prev = lastNode()
            prev?.let {
                node.prevNode = it
                it.nextNode = node
            }
        }
        val changeList = node.prevNode.listValue.filter { it.first >= node.idNode }
        node.prevNode.listValue.removeAll(changeList)
        node.listValue.addAll(changeList)
        nodes.add(node)
    }
    fun removeNode(nodeId: Int) {
        nodes.find { it.idNode == nodeId }?.let {
            it.nextNode.prevNode = it.prevNode
            it.prevNode.nextNode = it.nextNode
            it.prevNode.listValue.addAll(it.listValue)
            nodes.remove(it)
        }
    }
    fun addValue(id: Int, value: String) {
        if (nodes.size > 1) {
            nodes.find { it.idNode <= id && it.nextNode.idNode > id }?.listValue?.add(id to value)
        } else {
            nodes[0].listValue.add(id to value)
        }
    }
}