package:
	mvn -U clean package -DskipTests

install:
	mvn -U clean install -DskipTests

release:
	rm -f release.properties pom.xml.releaseBackup
	rm -f */release.properties */pom.xml.releaseBackup
	mvn release:prepare -B
	rm -f release.properties pom.xml.releaseBackup
	rm -f */release.properties */pom.xml.releaseBackup
