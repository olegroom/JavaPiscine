# deleting the directory
rm -rf target

# creating the new dir since java -d donesn't create it
mkdir target

# Set the destination directory for class files
javac  src/java/edu/school21/printer/*/*.java  -d ./target

# Specify where to find user class files
java -classpath ./target edu.school21.printer.app.Program . 0 /Users/rosfryd/Downloads/it.bmp

