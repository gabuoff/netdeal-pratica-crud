'use strict';

angular.module('ColaboradorApp.version', [
  'ColaboradorApp.version.interpolate-filter',
  'ColaboradorApp.version.version-directive'
])

.value('version', '0.1');