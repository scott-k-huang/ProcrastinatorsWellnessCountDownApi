$!/bin/bash

VERSION=""

#get parameters
while getopts v: flag
do
  case "${flag}" in
    v) VERSION=${OPTARG};;
  esac
done

#get highest tag number, then add v0.1.0 if doesn't exist
git fetch --prune --unshallow 2>/dev/null
#CURRENT_VERSION=`git describe --abbrev=0 --tags 2>/dev/null`
CURRENT_VERSION=''

if [[ $CURRENT_VERSION == '' ]]
then
  CURRENT_VERSION='v0.1.0'
fi
echo "Current Version: $CURRENT_VERSION"

#replace . with space so can split into array
CURRENT_VERSION_PARTS=(${CURRENT_VERSION//./ })

#get number parts
VNUM1=${CURRENT_VERSION_PARTS[0]}
VNUM2=${CURRENT_VERSION_PARTS[1]}
VNUM3=${CURRENT_VERSION_PARTS[2]}

if [[ $VERSION == 'major' ]]
then
  VNUM1=v$((VNUM1+1))
elif [[ $VERSION == 'minor' ]]
then
  VNUM2=$((VNUM2+1))
  echo "Minor $VNUM2"
elif [[ $VERSION == 'patch' ]]
then
  VNUM3=$((VNUM3+1))
  echo "Patch $VNUM3"
else
  echo "No version type (https://semver.org) or incorrect type specified, try -v [major, minor, patch]"
  exit 1
fi

echo "Major $VNUM1"
echo "Minor $VNUM2"
echo "Patch $VNUM3"

#create new tag
NEW_TAG="$VNUM1.$VNUM2.$VNUM3"
echo "($VERSION) updating $CURRENT_VERSION to $NEW_TAG"

#get current hash and see if it has a tag
GIT_COMMIT=`git rev-parse HEAD`
NEEDS_TAG=`git describe --contains $GIT_GIT_COMMIT 2>/dev/null`

#only if no tag already
if [ -z "$NEEDS_TAG" ]; then
  echo "Tagged with $NEW_TAG"
  git tag $NEW_TAG
  git push --tags
  git push
else
  echo "Already a tag on this commit"
fi

echo ::set-output name=git-tag::$NEW_TAG

exit 0