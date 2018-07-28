#!/bin/bash

<<<<<<< HEAD
mvn clean install --settings travis/settings.xml
=======
PROJECT_VERSION=`mvn -q -Dexec.executable="echo" -Dexec.args='${project.version}' --non-recursive exec:exec`

# Don't deploy pull requests (there are no secrets, anyway)
# And don't deploy releases, they are already deployed by the updater before this,
# and are signed.
if [[ "${TRAVIS_PULL_REQUEST}" == "false" && $PROJECT_VERSION == *"-SNAPSHOT" && "$TRAVIS_BRANCH" == "master" ]]; then
	mvn clean deploy --settings travis/settings.xml
else
	mvn clean install --settings travis/settings.xml
fi
>>>>>>> e9bf6ec55c5b440a5ed5dd6f3a5d84a30e756b3b
