rm -rf target lib
mkdir target lib

curl -s -o lib/jcommander-1.82.jar https://repo1.maven.org/maven2/com/beust/jcommander/1.82/jcommander-1.82.jar
curl -s -o lib/JCDP-4.0.2.jar https://repo1.maven.org/maven2/com/diogonunes/JCDP/4.0.2/JCDP-4.0.2.jar


javac -classpath lib/jcommander-1.82.jar:lib/JCDP-4.0.2.jar `find src/java -name "*.java"` -d target

cp -R src/resources target/.

jar xf lib/jcommander-1.82.jar
jar xf lib/JCDP-4.0.2.jar

mv com target

rm -rf META-INF

jar cfm ./target/images-to-chars-printer.jar src/manifest.txt -C target .

java -jar target/images-to-chars-printer.jar --white=RED --black=GREEN
