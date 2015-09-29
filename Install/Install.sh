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
yum install -y gcc gcc-c++ screen vim nano unzip curl wget man git strace emacs
echo '...done'


##
# Install Cassandra
#
echo '--- Installing dependencies ---'
yum install -y java
cp -vp /workspace/Database/Install/Repo/Datastax /etc/yum.repos.d/datastax.repo
yum -y install dsc20
chkconfig cassandra on #Turn on on boot
echo '...done'

##
# Install Composer because we all enjoy deployable code
#
echo '--- Installing composer ---'
if [[ ! -f /usr/local/bin/composer ]]; then
    curl -s https://getcomposer.org/installer | php
	# Make Composer available globally
	mv composer.phar /usr/local/bin/composer
else
	echo '[composer already installed]'
fi
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