Sample code to demonstrate the issue https://github.com/testcontainers/testcontainers-scala/issues/171.

Run with:

    sbt "testOnly -- --exclude-categories=issue171.Slow"

With that command, no test in `TestSuite` is executed, because `TestSuite` is
annotated with the category `issue171.Slow`. However, the containers are still
started.
