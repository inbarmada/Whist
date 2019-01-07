JAVAC="c:/program Files/Java/jdk1.8.0_161/bin/javac.exe"
RM=rm

PACKAGE = com/example/s243476/whist
SRC_DIR = $(PACKAGE)
PLATFORM_DIR = $(SRC_DIR)/platform/JDK

WHIST_CLASSES = Card Hand Deck Player Game
PLATFORM_CLASSES =  UI
MAIN_CLASSES =  Main
 
TARGETS =  $(addsuffix .class,$(PLATFORM_CLASSES)) $(addsuffix .class,$(WHIST_CLASSES)) $(addsuffix .class,$(MAIN_CLASSES))
 
VPATH=$(SRC_DIR):$(PLATFORM_DIR)


%.class: %.java
	@echo javac $< $@
	@$(JAVAC) -sourcepath "./" $< -d .
	

all:  $(TARGETS)


clean:  
	$(RM) $(PACKAGE)/*.class
	
display:
	@echo $(TARGETS)	
	@echo $(VPATH)