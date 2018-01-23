CC=g++
CFLAGS=-c -std=c++11 -Wall
SOURCES=../utils.cpp ../password_generator.cpp tests.cpp
OBJECTS=$(SOURCES:.cpp=.o)
EXECUTABLE=run_tests

all: $(SOURCES) $(EXECUTABLE)

$(EXECUTABLE): $(OBJECTS)
	$(CC) $(LDFLAGS) $(OBJECTS) -o $@

.cpp.o:
	$(CC) $(CFLAGS) $< -o $@

clean:
	rm *o run_tests
