#!/usr/bin/python

import sys, getopt

def main(argv):
   inputfile = ''
   outputfile = ''
   try:
      opts, args = getopt.getopt(argv,"hi:o:",["input=","output="])
   except getopt.GetoptError:
      print('test.py -i <inputfile> -o <outputfile>')
      sys.exit(2)
   for opt, arg in opts:
      if opt == '-h':
         print('test.py -i <inputfile> -o <outputfile>')
         sys.exit()
      elif opt in ("-i", "--input"):
         inputfile = arg
      elif opt in ("-o", "--output"):
         outputfile = arg
   print('Input file is {}'.format(inputfile))
   print('Output file is {}'.format(outputfile))
   
   try:
      f = open(inputfile, "r")
      for line in f:
         if "\includegraphics" in line and ".puml" in line:
            start_tex = line.index("\includegraphics")
            length = len("\includegraphics")
            end_tex = start_tex+length
            print("start_tex: {} | end_tex: {}".format(start_tex, end_tex))
            
            start_fileext = line.index(".puml", end_tex)
            length = len(".puml")
            end_fileext = start_fileext+length
            print("start: {} | end: {}".format(start_fileext, end_fileext))
            
            url = line[end_tex+1:end_fileext]
            print("url: ".format(url))
   except Exception as e:
      print("Unable to process tex: {}".format(e))
   finally:
      f.close()

if __name__ == "__main__":
   main(sys.argv[1:])
