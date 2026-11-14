// @ts-check

import config from '@exercism/eslint-config-javascript';
import maintainersConfig from '@exercism/eslint-config-javascript/maintainers.mjs';

import globals from 'globals';

export default [
  ...config,
  ...maintainersConfig,
  {
    // Keep the severity used by the previous exercise config so that
    // personal solutions only produce warnings, not lint failures.
    rules: {
      eqeqeq: ['warn', 'smart'],
    },
  },
  {
    files: maintainersConfig[1].files,
    rules: {
      'jest/expect-expect': ['warn', { assertFunctionNames: ['expect*'] }],
    },
  },
  {
    // Test files are copied verbatim from the exercism track, so keep the
    // style-only rules relaxed there instead of diverging from upstream.
    files: ['*.spec.js', '**/*.spec.js'],
    rules: {
      'no-unused-vars': 'off',
      'jest/no-alias-methods': 'off',
      'jest/no-jasmine-globals': 'off',
    },
  },
  {
    files: ['**/*.js'],
    languageOptions: {
      globals: {
        ...globals.node,
        ...globals.jest,
      },
    },
  },
  {
    ignores: ['node_modules/**', 'bin/**'],
  },
];
