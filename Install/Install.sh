#!/usr/bin/env bash

###############################################################################
#
# API [API.git] Provision Shell Script
#
#				..Kris
###

##
# Update our system first
#
echo '--- Updating ---'
yum -y update
echo '...done'

##
# Define front end dependencies here
# If we are missing a package on the server and it needs to be installed
# It is critical that we also add it here
#
echo '--- Installing dependencies ---'
yum install -y gcc gcc-c++ screen vim nano unzip curl wget man git strace emacs kernel-devel java-devel
mkdir /data
echo '...done'

##
# Install Cassandra
#
echo '--- Installing Cassandra ---'
yum install -y java
cp -vp /workspace/Database/Install/Documents/Cassandra/datastax.repo /etc/yum.repos.d/datastax.repo
yum -y install dsc20
rm -rf /etc/cassandra/conf
mkdir /etc/cassandra/conf
cp -vp /workspace/Database/Install/Documents/Cassandra/cassandra.yaml /etc/cassandra/conf/cassandra.yaml #Cassandra Configure file
cp -vp /workspace/Database/Install/Documents/Cassandra/log4j-server.properties /etc/cassandra/conf/log4j-server.properties #Cassandra log4j file
cp -vp /workspace/Database/Install/Documents/Cassandra/cassandra /etc/init.d/cassandra #Cassandra init rc script
service cassandra start
service cassandra stop



##
# Install ElasticSearch
# 
echo '--- Installing ElasticSearch ---'
rpm --import http://packages.elasticsearch.org/GPG-KEY-elasticsearch
cp -vp /workspace/Database/Install/Documents/ElasticSearch/elasticsearch.repo /etc/yum.repos.d/elasticsearch.repo
sudo yum -y install elasticsearch
service elasticsearch start
service elasticsearch stop
echo '...done'

##
# Install Indexer
#
##
# Install ElasticSearch
# 
echo '--- Installing Indexer ---'
# ..
echo '...done'

##
# Install Indexer
#
##
# Install ElasticSearch
# 
echo '--- Installing Indexer ---'
# ..
echo '...done'





##
# Lets figure out how you can access this thing
# Spit out some IP addresses to try
#
echo '********************************************************************************'
echo '********************************************************************************'
echo '*'
echo '* You should now be able to find the VM IP address in here :' 
echo '*'
echo '*'
ifconfig | grep "inet"
echo '*'
echo '*'
echo '********************************************************************************'
echo '********************************************************************************'

##
# We should now have an updated and awesome dev server!
#
service cassandra start
service elasticsearch start
