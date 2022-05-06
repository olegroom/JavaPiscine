# deleting the directory
rm -rf target

# creating the new dir since java -d donesn't create it
mkdir target

# Set the destination directory for class files
javac `find . -name "*.java"` -d target

cp -R src/resources target/.

jar cfm ./target/images-to-chars-printer.jar src/manifest.txt -C target .
chmod u+x target/images-to-chars-printer.jar

java -jar target/images-to-chars-printer.jar . 0