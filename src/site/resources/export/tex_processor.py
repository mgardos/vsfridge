#!/usr/bin/python

import sys, getopt
import requests

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
      output_content = ""
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
            
            diagram_url = line[end_tex+1:end_fileext]
            print("diagram url: {}".format(diagram_url))
            
            start_filename = diagram_url.rindex("/")
            diagram_filename = diagram_url[start_filename+1:start_fileext]+".png"
            print("diagram filename: {}".format(diagram_filename))

            diagram = requests.get(diagram_url, allow_redirects=True)
            diagram_file = open(diagram_filename, 'wb')
            diagram_file.write(diagram.content)
            diagram_file.close()
            
            line_rewrite = line[0:end_tex+1]+diagram_filename+"}"
            output_content += line_rewrite
            print("tex file line rewrite: {}".format(line_rewrite))
         else:
            output_content += line
            
      if len(output_content) > 0:
         tex_file = open(outputfile, "w")
         tex_file.write(output_content)
         tex_file.close()
   except Exception as e:
      print("Unable to process tex: {}".format(e))
   finally:
      f.close()

if __name__ == "__main__":
   main(sys.argv[1:])
