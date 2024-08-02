'use client'

import FilterIcon from '/public/icons/filter-square.svg'
import { useState } from 'react'
import { motion, Variants } from 'framer-motion'

const itemVariants: Variants = {
  open: {
    opacity: 1,
    y: 0,
    transition: { type: 'spring', stiffness: 300, damping: 24 },
  },
  closed: { opacity: 0, y: 20, transition: { duration: 0.2 } },
}

export default function ReviewMenuFilter() {
  const [isOpen, setIsOpen] = useState(false)

  return (
    <motion.nav
      initial={false}
      animate={isOpen ? 'open' : 'closed'}
      className="menu mr-5"
    >
      <motion.button
        whileTap={{ scale: 0.97 }}
        onClick={() => setIsOpen(!isOpen)}
        className="w-[11rem] h-full bg-primary-400 rounded-[4.5rem] flex items-center"
      >
        <FilterIcon width={24} height={24} className="ml-[1rem]" />
        <p className="m-auto text-white">슈퍼마켓</p>
      </motion.button>
      <motion.ul
        className="bg-white mt-1"
        variants={{
          open: {
            clipPath: 'inset(0% 0% 0% 0% round 10px)',
            transition: {
              type: 'spring',
              bounce: 0,
              duration: 0.7,
              delayChildren: 0.3,
              staggerChildren: 0.05,
            },
          },
          closed: {
            clipPath: 'inset(10% 50% 90% 50% round 10px)',
            transition: {
              type: 'spring',
              bounce: 0,
              duration: 0.3,
            },
          },
        }}
        style={{ pointerEvents: isOpen ? 'auto' : 'none' }}
      >
        <motion.li
          variants={itemVariants}
          className="text-center hover:text-white py-[0.5rem] hover:bg-gray-400"
        >
          Item 1{' '}
        </motion.li>
        <motion.li
          variants={itemVariants}
          className="text-center hover:text-white py-[0.5rem] hover:bg-gray-400"
        >
          Item 2{' '}
        </motion.li>
        <motion.li
          variants={itemVariants}
          className="text-center hover:text-white py-[0.5rem] hover:bg-gray-400"
        >
          Item 3{' '}
        </motion.li>
        <motion.li
          variants={itemVariants}
          className="text-center hover:text-white py-[0.5rem] hover:bg-gray-400"
        >
          Item 4{' '}
        </motion.li>
        <motion.li
          variants={itemVariants}
          className="text-center hover:text-white py-[0.5rem] hover:bg-gray-400"
        >
          Item 5{' '}
        </motion.li>
      </motion.ul>
    </motion.nav>
  )
}
