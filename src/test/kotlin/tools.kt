fun getResource(path : String) : String {
    return object {}.javaClass.getResource(path)!!.readText()
}