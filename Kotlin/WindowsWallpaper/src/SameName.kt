import java.io.*


fun main() {

    val file =
        File("C:\\Users\\lk139\\AppData\\Local\\Packages\\Microsoft.Windows.ContentDeliveryManager_cw5n1h2txyewy\\LocalState\\Assets")

    file.list().forEach {
        println("源文件 $it")
    }

    file.listFiles().forEach { it2 ->

        val byt = ByteArray(it2.length().toInt())
        val fileInputStream = FileInputStream(it2)

        val len = fileInputStream.read(byt)
        val file1 = File("F:\\Desktop\\${it2.name}.jpg")
        val fileOutputStream = FileOutputStream(file1)
        fileOutputStream.write(byt, 0, len)
        fileOutputStream.close()
        fileInputStream.close()

        println("输出到桌面  $file1")
    }


}