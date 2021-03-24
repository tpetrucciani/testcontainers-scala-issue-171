package issue171

import com.dimafeng.testcontainers.PostgreSQLContainer
import com.dimafeng.testcontainers.munit.TestContainersForAll
import munit.FunSuite
import org.junit.experimental.categories.Category
import org.testcontainers.utility.DockerImageName

class Slow extends munit.Tag("Slow")

@Category(Array(classOf[Slow]))
class TestSuite extends FunSuite with TestContainersForAll {

  override type Containers = PostgreSQLContainer

  override def startContainers(): PostgreSQLContainer = {
    PostgreSQLContainer
      .Def(
        dockerImageName = DockerImageName.parse("postgres:12"),
      )
      .start()
  }

  test("sample test 1") {
    withContainers { pgContainer: PostgreSQLContainer =>
      Thread.sleep(2000)
      println(s"test 1 done - DB URL = ${pgContainer.jdbcUrl}")
    }
  }

  test("sample test 2") {
    withContainers { pgContainer: PostgreSQLContainer =>
      Thread.sleep(2000)
      println(s"test 2 done - DB URL = ${pgContainer.jdbcUrl}")
    }
  }

}
