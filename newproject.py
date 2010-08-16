#!/usr/bin/env python

import os
import pwd
import shutil
import sys

# Configuration section:
#
# environment:
# $SRCROOT is the basedir to use for all source. Projects go in
#     $SRCROOT/$projname by default.
# $PACKAGE_ROOT is the base package (e.g., 'com.example') under which
#     your project lives.

# Where are we in the file system.
basedir = "."
templatedir = "."

def env(var, default):
  """ Return environment variable '$var', or 'default' if unset. """
  val = os.getenv(var)
  if None == val:
    return default
  return val


def input_string(prompt, default=""):
  """ Gets a string value from the user after offering
      the specified prompt. The default value is used if
      the user enters an empty string.
  """

  print prompt
  user_response = raw_input("[" + str(default) + "]> ")
  if user_response == '':
    return default
  else:
    return user_response



TYPE_JAVA = 1
TYPE_MAPREDUCE = 2
TYPE_MAPRED = 3

TYPE_MINIMUM = TYPE_JAVA
TYPE_MAXIMUM = TYPE_MAPRED

def get_project_type():
  """ Return the type of the project
    1 - java
    2 - hadoop mapreduce (new API)
    3 - hadoop mapred (old API)
  """

  print "Project type:"
  print "  [*] 1 - Java"
  print "      2 - Hadoop MapReduce (new API)"
  print "      3 - Hadoop mapred (old API)"
  typstr = input_string("What type of project are you creating", 1)
  v = int(typstr)
  if v < TYPE_MINIMUM or v > TYPE_MAXIMUM:
    return get_project_type()
  return v
 

def get_project_name():
  """ Return a project name """
  projname = input_string("What is the project name?", "meep")
  if "" == projname:
    print "Please enter a project name."
    return get_project_name()
  return projname


def get_project_dir(name):
  """ Return the directory to use for the project """

  srcroot = env("SRCROOT", os.path.join(os.path.expanduser("~"), "src"))
  defdir = os.path.join(srcroot, name)

  return input_string("Enter the project root directory:", defdir)


def copy_base_files(projname, projdir):
  """ Copy all files from common dir into the new project """
  global templatedir

  common_files = os.path.join(templatedir, "common")
  shutil.copytree(common_files, projdir)

def copy_src_files(srcnature, main_package, main_package_dir, proj_main_name,
    projdir, projname):
  """ Copy files of a specific source type into the appropriate directories
      in the project.
  """
  global templatedir
  srcdir = os.path.join(templatedir, srcnature + "-src")


  dest_java_dir = os.path.join(projdir, "src", "java", main_package_dir)
  os.makedirs(dest_java_dir)
  shutil.copy(os.path.join(srcdir, "mainclass.java"), \
      os.path.join(dest_java_dir, proj_main_name + ".java"))

  if os.path.exists(os.path.join(srcdir, "maintest.java")):
    dest_test_dir = os.path.join(projdir, "src", "test", main_package_dir)
    os.makedirs(dest_test_dir)
    shutil.copy(os.path.join(srcdir, "maintest.java"), \
        os.path.join(dest_test_dir, proj_main_name + ".java"))

  if os.path.exists(os.path.join(srcdir, "mainbin")):
    dest_bin_dir = os.path.join(projdir, "bin")
    os.makedirs(dest_bin_dir)
    shutil.copy(os.path.join(srcdir, "mainbin"), \
        os.path.join(dest_bin_dir, projname))


def substitute_vars(projdir, varname, value):
  """ Replace %varname% in all files in projdir with value. """
  cmd = "find \"" + projdir + "\" -type f -exec sed -i -e 's/%" + varname \
      + "%/" + value + "/g' {} \\;"
  os.system(cmd)


def main(argv):
  global basedir, templatedir

  # Where does this script live in the filesystem.
  basedir = os.path.dirname(os.path.realpath(argv[0]))
  templatedir = os.path.join(basedir, "template")

  projname = get_project_name()
  projdir = get_project_dir(projname)

  projtype = get_project_type()

  default_class_name = projname[0].upper() + projname[1:]
  proj_main_name = input_string("Main class name", default_class_name)
  github_username = input_string("github username", pwd.getpwuid(os.getuid())[0])

  # TODO: Make this parameterized input
  license = "Apache 2.0"

  # TODO: Make this parameterized input
  copyright = "(c) Copyright 2010."

  package_root = env("PACKAGE_ROOT", "org." + projname)
  main_package = input_string("Main package for the project", \
      package_root + "." + projname)
  main_package_dir = main_package.replace(".", "/")

  # TODO: Determine the actual dependencies here.

  copy_base_files(projname, projdir)

  copy_src_files("java", main_package, main_package_dir, \
      proj_main_name, projdir, projname)

  if projtype == TYPE_MAPREDUCE:
    copy_src_files("mapreduce", projname, projdir)
  elif projtype == TYPE_MAPRED:
    copy_src_files("mapred", projname, projdir)

  substitute_vars(projdir, "github.user", github_username)
  substitute_vars(projdir, "proj.name", projname)
  substitute_vars(projdir, "ProjectName", proj_main_name)
  substitute_vars(projdir, "PROJNAME", projname.upper())
  substitute_vars(projdir, "license", license)
  substitute_vars(projdir, "copyright", copyright)
  substitute_vars(projdir, "main.package", main_package)

  print "Created new project in " + projdir

if __name__ == "__main__":
  sys.exit(main(sys.argv))




