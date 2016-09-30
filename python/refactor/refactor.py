#!/usr/bin/env python
# Requires Python 3.0 or greater

# Test suite. Assumes subfolder 'test' of current path contains test files.
# python regEx.py "([a-z]*)_([a-z]*)_([a-z]*)" "\2_\3_\1" test\*.txt
# python regEx.py "([a-z]*)_([a-z]*)_([a-z]*)_([a-z]*)_([a-z]*)_([a-z]*)_([a-z]*)" "\5_\7_\2_\6_\3_\4_\1" test\*
# python regEx.py foo bar test\foo1 test\foo2
# python regEx.py foo bar test\*
# python regEx.py "---*" "-" test\*-*

# python refactor.py "actorLst \= new std\:\:vector\< WO\* \>\;" "this->actorLst = new WorldList();"
# REPLACES "actorLst = new std::vector< WO* >;" with
#         "this->actorLst = new WorldList();"

import sys
import os
import os.path
import glob
import re
import string

import fileinput

global globalViewMode
globalMatchedFilesCount = 0
globalViewMode = 1  # 1 means only view what would be modifed, 0 means perform the regex modification

global lines
lines = []

def refactorTextWithinFile(oldFileName, regExp, re2):
   # open file
#    f = open(oldFileName, "w+")
   # read file into string
#    for line in f.readlines():
    #print(lines)
   # apply regex substitution to input string
#        lines = RegExsub(line, regExp, re2)
#        if (globalViewMode == 0):
            #f.write(lines)
#            print("hello")
#        else:
#            print(lines)
#    f.close()
   #if output string has changed, the regex found a match and was applied so write it to file
    #print(oldFileName)
    if (globalViewMode == 0):
        f = open(oldFileName, "r")
        for line in f.readlines():
            #print("Before: " + line)
            lines.append(RegExsub(line, regExp, re2))
            #print("After: " + o)
        f.close()

        h = open(oldFileName, "w+")
        for item in lines:
            # print(item)
            h.write("%s" % item.strip() + "\n")

    else:
        with fileinput.input(oldFileName, False) as f:
            for line in f:
                lines.append(RegExsub(line, regExp, re2))
            fileinput.close()
            #print(lines)

    for item in lines:
        print(item.strip())
    #print(lines)


if (len(sys.argv) != 4):
    print("")
    print("Usage (from usr/modules/): refactor (v|r) RegExToFind RegExToReplace")
    print("   v: means view-only - no files will be modified. Only those")
    print("      files that would be modified are listed.")
    print("   r: replace - executes the regex on all matched files.")
    print("")
    print("Examples:")
    print("python refactor.py \"([a-z]*)_([a-z]*)_([a-z]*)\" \"\\2_\\3_\\1\"")
    print(
        "python refactor.py \"([a-z]*)_([a-z]*)_([a-z]*)_([a-z]*)_([a-z]*)_([a-z]*)_([a-z]*)\" \"\\5_\\7_\\2_\\6_\\3_\\4_\\1\"")
    print("python refactor.py foo bar")
    print("python refactor.py foo bar")
    print("python refactor.py \"---*\" \"-\"")
    #       python renameFiles.py v "GLViewNyklDTED\.cpp" "FunDTED.cpp" (No need to escape quotes in doc)
    print("python renameFiles.py v \"GLViewNyklDTED\.cpp\" \"FunDTED.cpp\"")
    # Replace SteaMiE* with Aftr*
    # python refactor.py v "(?i)steamie([A-Za-z0-9]*)" "Aftr\1"
    quit()

# ([A-Z0-9a-z]*)_([A-Z0-9a-z\s]*)_*([A-Z0-9a-z]*).?([A-Z0-9a-z]*) should work for all example cases

# fileExt = sys.argv[1]
if (sys.argv[1] == 'r' or sys.argv[1] == 'R'):
    #we are going to actually REPLACE!!!
    globalViewMode = 0
    print("Going to replace!")
else:
    #we are just going to view what would be replaced if 'R' was passed in.
    print("Only going to view, no changes will occur on files.")

print("Output will look like this:")

#Read in regular expressions
def RegExsub(fileContents, expression, order) :
    #print(fileContents)
    #print(expression)
    #r = re.compile(expression)
    #o = r.sub(order,fileContents)
    o = re.sub(expression, order, fileContents)
    o.strip()
    return o
    #print(o)
    #print(o)
#and output if we are in replace or view mode

#Compile regex to ensure validity


#find all files we want to search. In this example all files in './test/*.txt'
#listoffiles = glob.glob('./test/*.txt')
#print(listoffiles)

#for each file found, call refactorTextWithinFile which applies regex to it
#afile = iter(listoffiles)
#for a in afile:
    #print(a)
a = "./test/simple.txt"
refactorTextWithinFile(a, sys.argv[2], sys.argv[3])
