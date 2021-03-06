resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += Resolver.url("scalasbt", new URL("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases"))(Resolver.ivyStylePatterns)

resolvers += Resolver.file("ivy2-local", new File(Path.userHome.absolutePath + "/.ivy2/local"))(Resolver.ivyStylePatterns)

addSbtPlugin("com.typesafe" % "sbt-native-packager" % "0.4.3" withSources )

addSbtPlugin("play" % "sbt-plugin" % "2.0.2")

name := "play2-native-packager-plugin"

organization := "net.kindleit"

version := "0.2-SNAPSHOT"

description := "Play2 plugin for producing native system distribution packages"

scalaVersion := "2.9.1"

sbtVersion := "0.11.3"

sbtPlugin := true

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { x => false }

pomExtra := (
  <url>https://github.com/kryptt/play2-native-packager-plugin</url>
  <licenses>
  <license>
    <name>Apache 2</name>
    <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
    <distribution>repo</distribution>
  </license>
  </licenses>
    <scm>
    <url>git@github.com:kryptt/play2-native-packager-plugin.git</url>
    <connection>scm:git:git@github.com:kryptt/play2-native-packager-plugin.git</connection>
  </scm>
  <developers>
    <developer>
      <id>kryptt</id>
      <name>Rodolfo Hansen</name>
      <url>http://hobbes-log.blogspot.com</url>
    </developer>
  </developers>
)

publishTo <<= version { (v) =>
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/")
  else
    Some("releases" at "https://oss.sonatype.org/service/local/staging/deploy/maven2/")
}

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
