all: run

clean:
	rm -f out/Bluck.jar out/PrimeSum.jar

out/Bluck.jar: out/parcs.jar src/Bluck.java src/Node.java
	@javac -cp out/parcs.jar src/Bluck.java src/Node.java
	@jar cf out/Bluck.jar -C src Bluck.class -C src Node.class
	@rm -f src/Bluck.class src/Node.class

out/PrimeSum.jar: out/parcs.jar src/PrimeSum.java src/Node.java
	@javac -cp out/parcs.jar src/PrimeSum.java src/Node.java
	@jar cf out/PrimeSum.jar -C src PrimeSum.class -C src Node.class
	@rm -f src/PrimeSum.class src/Node.class

build: out/Bluck.jar out/PrimeSum.jar

run: out/Bluck.jar out/PrimeSum.jar
	@cd out && java -cp 'parcs.jar:Bluck.jar' Bluck
