module.exports = {
  devServer: {
    proxy: {
      '/api': {
        target: 'http://localhost:7777',
        changeOrigin: true,
        logLevel: 'debug',
      },
    }
  }
}
