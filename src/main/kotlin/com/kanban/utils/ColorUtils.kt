package com.kanban.utils

class ColorUtils {

    companion object {
        fun getRandom(): String = arrayOf(
                "#001f3f", "#0074D9", "#7FDBFF", "#39CCCC",
                "#B10DC9", "#F012BE", "#85144b", "#FF4136",
                "#FF851B", "#FFDC00", "#3D9970", "#2ECC40",
                "#01FF70"
            ).random()

    }

}
