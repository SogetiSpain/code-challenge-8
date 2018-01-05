CC=g++
CFLAGS=-c -std=c++11 -Wall
SOURCES=utils.cpp password_generator.cpp main.cpp 
OBJECTS=$(SOURCES:.cpp=.o)
EXECUTABLE=password_generator

all: $(SOURCES) $(EXECUTABLE)

$(EXECUTABLE): $(OBJECTS)
	$(CC) $(LDFLAGS) $(OBJECTS) -o $@

.cpp.o:
	$(CC) $(CFLAGS) $< -o $@

clean:
	rm *o password_generator
