package vc.rux.demo.springnotebook

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@ComponentScan
class NotebookApp {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var value = 32
            println("hi from kotlin, value = $value")

            SpringApplication.run(NotebookApp::class.java, *args)
        }
    }
}
