fun main(argv: Array<String>) {
    val chordNode = ChordNode()
    chordNode.addNode(Node(10))
    chordNode.addValue(100, "test1")
    chordNode.addNode(Node(50))
    chordNode.addNode(Node(30))
    chordNode.removeNode(50)
}
