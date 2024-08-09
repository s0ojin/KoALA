/** @type {import('next').NextConfig} */
const nextConfig = {

  images: {
    domains: ['koalabucket1.s3.amazonaws.com'],
  },

  output: 'standalone',
  webpack(config) {
    config.module.rules.push({
      test: /\.svg$/,
      use: ['@svgr/webpack'],
    })

    return config
  },
}

export default nextConfig
