JAVAC=javac
RM=rm

COMPILE_OPT =  "-Xlint:unchecked"

PACKAGE = whist
SRC_DIR = $(PACKAGE)
PLATFORM_DIR = $(SRC_DIR)/platform/JDK

WHIST_CLASSES =  Hand Deck Player AutoPlayer RealPlayer Game CardSuit CardRank Card Contract
PLATFORM_CLASSES =  UI Main
 
TARGETS =  $(addsuffix .class,$(PLATFORM_CLASSES)) $(addsuffix .class,$(WHIST_CLASSES)) 
 
VPATH=$(SRC_DIR):$(PLATFORM_DIR)


%.class: %.java
	@echo javac $< $@
	@$(JAVAC) $(COMPILE_OPT) -sourcepath ./ $< -d .
	

all:  $(TARGETS)


clean:  
	$(RM) $(PACKAGE)/*.class
	
display:
	@echo $(TARGETS)	
	@echo $(VPATH)
