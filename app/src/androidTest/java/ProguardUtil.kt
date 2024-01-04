import java.io.File
import java.lang.StringBuilder

/**
 * 混淆字典生成工具
 */
object ProguardUtil {
    private const val USER_DIR = "user.dir"

    @JvmStatic
    fun main(args: Array<String>) {
        val localPath = System.getProperty(USER_DIR)
        println("rootPath:$localPath")

        val firstMap = arrayOf("l", "L")
        val map = arrayOf("l", "L", "i")
//        val line = (2000..3000).random()
        val line = (500..1000).random()
        println("行数：$line")
        val proguards = ArrayList<String>()
        val content = StringBuilder()
        for (l in 0 until line) {
            val length = (10..20).random()
            val sb = StringBuilder()

            sb.append(firstMap[firstMap.indices.random()])
            for (i in 0..length) {
                sb.append(map[map.indices.random()])
            }
            sb.append("\n")
            val tmpStr = sb.toString()
            if (proguards.contains(tmpStr)) {
                println("已存在,不写入")
                continue
            }

            println(("${l + 1}：$tmpStr"))
            proguards.add(tmpStr)
            content.append(tmpStr)
        }

        val targetFile = File(localPath + File.separator + "app" + File.separator + "proguard_keywords.txt")
        if (targetFile.exists()) targetFile.delete()
        targetFile.writeText(content.toString())

    }
}